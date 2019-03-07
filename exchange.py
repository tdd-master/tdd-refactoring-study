class Dollar:
    def __init__(self, amount):
        self.__amount = amount

    def times(self, multiplier):
        return Dollar(self.__amount * multiplier)

    def equals(self, object):
        dollar = object
        return self.__amount == dollar.__amount

    def __eq__(self, other):
        return self.__amount == other.__amount