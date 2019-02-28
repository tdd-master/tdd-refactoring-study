# -*- coding: utf-8 -*-
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
"""VendingMachine"""

from abc import ABCMeta, abstractmethod
import argparse

class CheckVaild:
    def __init__(self):
        pass

    def check_coin_value(self, coin, value):
        assert coin > value

    def check_amount_over_0(self, items):
        def print_amount_error(value):
            assert value >= 0, "Mount must be >= 0"

        for key, value in items.items():
            if value < 0:
                print_amount_error(value)

class Items:
    def __init__(self, items):
        self.items = items

    def __add__(self, other):
        self.items.update(other.items)
        return self.items


class ItemsAmounts(Items):
    def __init__(self, items):
        super().__init__(items)

class MachineInput(ItemsAmounts):
    def __init__(self, items):
        self.coin = 0
        self._check = CheckVaild()
        super(MachineInput, self).__init__(items)

    def add_coin(self, coin):
        self.coin += coin

    def add_amounts(self, amount_items):
        self.amount_items = amount_items
        print("-현재 자판기 아이템 목록-")
        for key, value in self.amount_items.items():
            print("{key} : {value}".format(key=key, value=value))
        print("\n")

class MachineOutput:
    def __init__(self, coin, change, items, key):
        self.coin = coin
        self.key = key
        self.change = change
        self.items = items

    def get_coins(self, coin):
        return "투입하신 금액은 {coin}원.".format(coin=str(coin))

    def get_change(self, change):
        return "거스름돈은 {change}원.".format(change=str(change))

    def get_selected_items(self, items, key):
        return "선택하신 {item}은 {value}원.".format(item=key, value=items[key])

    def __str__(self):
        print(self.get_coins(self.coin))
        print(self.get_selected_items(self.items, self.key))
        print(self.get_change(self.change))
        return 'Done'

class VendingMachine():
    def __init__(self, items={'water':500}):
        self._input = MachineInput(items)

    def insert_coin(self, coin):
        self._input.add_coin(coin)

    def insert_amount_items(self, amount_items):
        self._input.add_amounts(amount_items)

    def get_items(self, coin, key):
        tot_values = self._input.items[key]
        self._input._check.check_coin_value(coin, tot_values)
        change = self._input.coin - self._input.items[key]
        self._input.amount_items[key] -= 1
        print (key,":",self._input.amount_items[key])
        return change

    def run(self, coin, key):
        self.insert_coin(coin)
        change = self.get_items(coin, key)
        self._output = MachineOutput(coin, change, self._input.items, key)
        print(self._output)

if __name__ == '__main__':
    PARSER = argparse.ArgumentParser(description='VendingMachine')
    PARSER.add_argument('-c', '--coin', default=1000, type=int, help='coin')
    PARSER.add_argument('-i', '--items', default='milk', type=str, help='selected items')
    ARGS = PARSER.parse_args()
    items = {'milk':600, 'water':500}
    amount_items = {'milk':5, 'water':1}
    VEN = VendingMachine(items)
    VEN.insert_amount_items(amount_items)
    VEN.run(ARGS.coin, ARGS.items)