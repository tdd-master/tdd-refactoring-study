import unittest
from exchange import Dollar, Franc

class TesCurrency(unittest.TestCase):
    def test_dollar_multiplication(self):
        five = Dollar(5)
        self.assertEqual(Dollar(10), five.times(2))
        self.assertEqual(Dollar(15), five.times(3))

    def test_franc_multiplication(self):
        five = Franc(5)
        self.assertEqual(Franc(10), five.times(2))
        self.assertEqual(Franc(15), five.times(3))

    def test_equality(self):
        self.assertTrue(Dollar(5).equals(Dollar(5)))
        self.assertFalse(Dollar(5).equals(Dollar(6)))
        self.assertTrue(Franc(5).equals(Franc(5)))
        self.assertFalse(Franc(5).equals(Franc(6)))


if __name__ == '__main__':
    unittest.main()
