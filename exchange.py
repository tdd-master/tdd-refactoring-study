class Money:
    def __init__(self, amount):
        self._amount = amount

    def equals(self, object):
        money = object
        return self._amount == money._amount

    def __eq__(self, other):
        return self._amount == other._amount


class Dollar(Money):
    def __init__(self, amount):
        super().__init__(amount)

    def times(self, multiplier):
        return Dollar(self._amount * multiplier)


class Franc(Money):
    def __init__(self, amount):
        super().__init__(amount)

    def times(self, multiplier):
        return Franc(self._amount * multiplier)
