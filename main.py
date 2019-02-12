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
"""Calculator using string"""

from abc import ABCMeta


class CheckVaild:
    def __init__(self):
        pass

    def check_coin_item(self, coin, value):
        assert coin > value

class MachineInput(CheckVaild):
    def __init__(self):
        self.coin = 0

    def insert_coin(self, coin):
        self.coin += coin

class MachineOutput:
    def __init__(self, change, selected_items, key):
        self.change = change
        self.selected_items = selected_items
        self.key = key

    def get_change(self, change):
        return "거스름돈은 {change}원 입니다.".format(change=str(change))

    def get_selected_items(self, items, key):
        return "선택하신 {item}은 {value}원 입니다.".format(item=key, value=items[key])

    def __str__(self):
        print(self.get_selected_items(self.selected_items, self.key))
        print(self.get_change(self.change))
        return 'Done'


if __name__ == '__main__':
    print ('Done')