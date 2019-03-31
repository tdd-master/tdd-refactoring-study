import unittest
from exchange import Money, Bank, Sum

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
        bank = Bank()
        reduced = bank.reduce(_sum, "USD")
        self.assertEqual(Money.dollar(10), reduced)

    def test_plus_return_sum(self):
        five = Money.dollar(5)
        result = five.plus(five)
        _sum = result
        self.assertEqual(five, _sum.augend)
        self.assertEqual(five, _sum.addend)

    def test_reduce_sum(self):
        _sum = Sum(Money.dollar(3), Money.dollar(4))
        bank = Bank()
        result = bank.reduce(_sum, "USD")
        self.assertTrue(Money.dollar(7).equals(result))

    def test_reduce_money(self):
        bank = Bank()
        result = bank.reduce(Money.dollar(1), "USD")
        self.assertEqual(Money.dollar(1), result)

    def test_reduce_money_difference_currency(self):
        bank = Bank()
        bank.addRate("CHF", "USD", 2)
        result = bank.reduce(Money.franc(2), "USD")
        self.assertEqual(Money.dollar(1), result)

    def test_array_equals(self):
        pass

    def test_identity_rate(self):
        self.assertEqual(1, Bank().rate("USD", "USD"))

    def test_mixed_addition(self):
        fiveBucks = Money.dollar(5)
        tenFranc = Money.franc(10)
        bank = Bank()
        bank.addRate("CHF", "USD", 2)
        result = bank.reduce(fiveBucks.plus(tenFranc), "USD")
        self.assertTrue(Money.dollar(10).equals(result))

if __name__ == '__main__':
    unittest.main()
