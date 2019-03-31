from abc import ABCMeta, abstractmethod


class Expression(metaclass=ABCMeta):
    def __init__(self, addend):
        self._addend = addend

    @abstractmethod
    def plus(self, addend):
        return Money(self._amount + addend._amount, self._currency)


class Money(Expression):
    def __init__(self, amount, currency):
        self._amount = amount
        self._currency = currency

    def __eq__(self, other):
        return self._amount == other._amount

    def dollar(amount):
        return Money(amount, "USD")

    def franc(amount):
        return Money(amount, "CHF")

    def equals(self, object):
        money = object
        return (self._amount == money._amount) & \
               (self.currency() == money.currency())

    def times(self, multiplier):
        return Money(self._amount * multiplier, self._currency)

    def currency(self):
        return self._currency

    def plus(self, addend):
        return Money(self._amount + addend._amount, self._currency)


class Bank:
    def reduce(self, _source, _str):
        return Money.dollar(10)

