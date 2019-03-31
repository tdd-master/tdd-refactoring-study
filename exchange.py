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

    def reduce(self, bank, _to):
        rate = bank.rate(self._currency, _to)
        return Money(self._amount / rate, _to)

class Sum:
    def __init__(self, augend, addend):
        self.augend = augend
        self.addend = addend

    def reduce(self, bank, _to):
        amount = self.augend._amount + self.addend._amount
        return Money(amount, _to)

class Pair:
    def __init__(self, _from, _to):
        self._from = _from
        self._to = _to
        self._dict = {_from, _to}

    def getDict(self):
        return str(self._dict)

    ## TODO: Convert str to hash
    def __hash__(self):
        return 0

    def equals(self, object):
        pair = object
        return pair._from == pair._to

class Bank:
    def __init__(self):
        self._rates = {}

    def reduce(self, _source, _to):
        return _source.reduce(self, _to)

    def rate(self, _from, _to):
        if (_from == _to):
            return 1
        return self._rates.get(Pair(_from, _to).getDict())

    def addRate(self, _from, _to, rate):
        self._rates.update({Pair(_from, _to).getDict():rate})


