from abc import ABCMeta, abstractmethod


class Item(metaclass=ABCMeta):
    def __init__(self):
        pass

    @abstractmethod
    def add_new_items(self, new_items):
        raise NotImplementedError('')

    @abstractmethod
    def sub_items(self, key):
        raise NotImplementedError('')

    @abstractmethod
    def set_value_by_key(self, key, new_value):
        raise NotImplementedError('')

    @abstractmethod
    def remove_all_items(self):
        raise NotImplementedError('')

class MoneyAmount(metaclass=ABCMeta):
    def __init__(self, coin):
        self.coin = coin

    @abstractmethod
    def add_coins(self, type):
        raise NotImplementedError('')

    @abstractmethod
    def sub_coins(self, type):
        raise NotImplementedError('')

    @abstractmethod
    def remove_all_coins(self, type):
        raise NotImplementedError('')
