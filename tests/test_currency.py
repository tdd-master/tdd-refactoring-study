import unittest
from exchange import Money, Bank

class TesCurrency(unittest.TestCase):
    def test_dollar_multiplication(self):
        five = Money.dollar(5)
        self.assertEqual(Money.dollar(10), five.times(2))
        self.assertEqual(Money.dollar(15), five.times(3))

    def test_franc_multiplication(self):
        five = Money.franc(5)
        self.assertEqual(Money.franc(10), five.times(2))
        self.assertEqual(Money.franc(15), five.times(3))

    def test_equality(self):
        self.assertTrue(Money.dollar(5).equals(Money.dollar(5)))
        self.assertFalse(Money.dollar(5).equals(Money.dollar(6)))
        self.assertFalse(Money.franc(5).equals(Money.dollar(5)))

    def test_currency(self):
        self.assertEqual("USD", Money.dollar(1).currency())
        self.assertEqual("CHF", Money.franc(1).currency())

    def test_simple_addition(self):
        five = Money.dollar(5)
        _sum = five.plus(five)
        self.assertEqual(Money.dollar(10), _sum)
        bank = Bank()
        reduced = bank.reduce(_sum, "USD")
        self.assertEqual(Money.dollar(10), reduced)


if __name__ == '__main__':
    unittest.main()
