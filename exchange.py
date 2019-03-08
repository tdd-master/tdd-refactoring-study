from abc import ABCMeta, abstractmethod

class Money(metaclass=ABCMeta):
    def __init__(self, amount, currency):
        self._amount = amount
        self._currency = currency

    def __eq__(self, other):
        return self._amount == other._amount

    def dollar(amount):
        return Dollar(amount, "USD")

    def franc(amount):
        return Franc(amount, "CHF")

    def equals(self, object):
        money = object
        return (self._amount == money._amount) & \
               (self.currency() == money.currency())

    def times(self, multiplier):
        return Money(self._amount * multiplier, self._currency)

    def currency(self):
        return self._currency


class Dollar(Money):
    def __init__(self, amount, currency):
        super(Dollar, self).__init__(amount, currency)


class Franc(Money):
    def __init__(self, amount, currency):
        super(Franc, self).__init__(amount, currency)

