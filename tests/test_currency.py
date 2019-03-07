import unittest
from exchange import Money

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
        self.assertTrue(Money.franc(5).equals(Money.franc(5)))
        self.assertFalse(Money.franc(5).equals(Money.franc(6)))
        self.assertFalse(Money.franc(5).equals(Money.dollar(5)))


if __name__ == '__main__':
    unittest.main()
