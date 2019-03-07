from abc import ABCMeta, abstractmethod

class Money(metaclass=ABCMeta):
    def __init__(self, amount):
        self._amount = amount

    def dollar(amount):
        return Dollar(amount)

    def franc(amount):
        return Franc(amount)

    def equals(self, object):
        money = object
        return (self._amount == money._amount) & \
               (type(self).__name__ == type(money).__name__)

    def times(self, multiplier):
       pass

    def __eq__(self, other):
        return self._amount == other._amount


class Dollar(Money):
    def __init__(self, amount):
        super(Dollar, self).__init__(amount)

    def times(self, multiplier):
        return Dollar(self._amount * multiplier)


class Franc(Money):
    def __init__(self, amount):
        super(Franc, self).__init__(amount)

    def times(self, multiplier):
        return Franc(self._amount * multiplier)
