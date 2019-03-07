import unittest
from exchange import Dollar

class TesCurrency(unittest.TestCase):
    def test_multiplication(self):
        five = Dollar(5)
        five.times(2)
        self.assertEqual(10, five.amount)


if __name__ == '__main__':
    unittest.main()
