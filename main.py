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

import argparse
from interface import MoneyAmount, Item
from check_vaild import CheckVaild

class MachinePrintOutput:
    def print_coin_monitor(self, coin):
        return "현재 금액은 {coin}원.".format(coin=str(coin))

    def print_main_monitor(self, items, key):
        return "선택하신 {item}은 {value}원.".format(item=key, value=items[key])

    def print_end_monitor(self):
        return "안녕히 가세요"

class MachineInputItem(Item):
    def __init__(self, items={'milk':5, 'water':5}):
        self.items = items

    def add_new_items(self, new_items):
        self.items.update(new_items)

    def sub_items(self, key):
        del self.items[key]

    def set_value_by_key(self, key, new_value):
        self.items[key] = new_value

    def remove_all_items(self):
        self.items = {}

class MachineInputCoin(MoneyAmount):
    def __init__(self, coin={'100', 0, '500', 0, '1000', 0}):
        self.coin = coin

    def add_coins(self, new_coin):
        for key, value in new_coin.items():
            self.coin[key] += value

    def sub_coins(self, new_coin):
        for key, value in new_coin.items():
            self.coin[key] -= value

    def remove_all_coins(self):
        for key, value in self.coin.items():
            self.coin[key] = 0

class MachineInput:
    def __init__(self):
        self.Amount = MachineInputItem({'milk': 5, 'water': 5})
        self.Values = MachineInputItem({'milk': 600, 'water': 500})
        self.Coins = MachineInputCoin({'100', 0, '500', 0, '1000', 0})

class CustomerInput(CheckVaild):
    def __init__(self):
        super(CustomerInput, self).__init__()
        self.coin = 0

    def insert_coin(self, coin):
        self.coin += coin

    def select_item(self, key):
        self.selected_item = key

class MachineCalcluator(CheckVaild):
    def get_the_balance(self, items, key, current_coin):
        change = current_coin - items[key]
        return change

    def get_the_value(self, items, key):
        return items[key]

    def sum_all_values(self, items):
        _sum = 0
        for key, value in items.items():
            _sum += value
        return _sum

class VendingMachine(MachineCalcluator, MachinePrintOutput):
    def __init__(self):
        self.Machine = MachineInput()
        self.Cust = CustomerInput()
        self.Cal = MachineCalcluator()

    def get_item(self, key):
        self.Cust.select_item(key)
        change = self.Cal.get_the_balance(items=self.Machine.Values.items,
                                           key=self.Cust.selected_item,
                                           current_coin=self.Cust.coin)
        return change

    def run(self, coin, key):
        self.Cust.insert_coin(coin)
        self.print_coin_monitor(self.Cust.coin)
        self.print_main_monitor(self.Machine.Values.items, key)
        change = self.get_item(key)
        print (change)

if __name__ == '__main__':
    PARSER = argparse.ArgumentParser(description='VendingMachine')
    PARSER.add_argument('-c', '--coin', default=1000, type=int, help='coin')
    PARSER.add_argument('-i', '--items', default='milk', type=str, help='selected items')
    ARGS = PARSER.parse_args()
    VEN = VendingMachine()
    VEN.run(ARGS.coin, ARGS.items)