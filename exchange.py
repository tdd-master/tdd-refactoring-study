from abc import ABCMeta, abstractmethod


class Expression(metaclass=ABCMeta):
    def __init__(self, addend):
        self._addend = addend

    @abstractmethod
    def plus(self, addend):
        raise NotImplementedError('')

    @abstractmethod
    def reduce(self, to):
        raise NotImplementedError('')


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
        return Sum(self, addend)

    def reduce(self, _to):
        return self

class Sum:
    def __init__(self, augend, addend):
        self.augend = augend
        self.addend = addend

    def reduce(self, _to):
        amount = self.augend._amount + self.addend._amount
        return Money(amount, _to)


class Bank:
    def reduce(self, _source, _to):
        if isinstance(_source, Money):
            return _source.reduce(_to)
        _sum = _source
        return _sum.reduce(_to)

