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
"""Test For VendingMachine"""

import unittest
import pytest
from main import MachineInput, MachineOutput, Items, ItemsAmounts, VendingMachine, CheckVaild

class TestOutPut(unittest.TestCase):
    def setUp(self):
        self.key = 'milk'
        self.selected_items = {'milk' : 500}
        self.change = 300
        self.coin = 1000
        self.out = MachineOutput(self.coin, self.change, self.selected_items, self.key)

    def test_print_change(self):
        print(self.out)

class TestInput(unittest.TestCase):
    def setUp(self):
        self.coin = 400
        self.key = 'milk'
        self.INPUT = MachineInput({'milk' : 600})

    @pytest.mark.xfail(raises=AssertionError)
    def test_input_less_than_value(self):
        self.INPUT._check.check_coin_value(self.coin, self.INPUT.items.get(self.key))

class TestItem(unittest.TestCase):
    def setUp(self):
        self.a = Items({'milk':600})
        self.b = Items({'water':500})
        self._check = CheckVaild()

    def test_add(self):
        c = self.a + self.b
        self.assertEqual(list(c.keys()), ['milk', 'water'])

    @pytest.mark.xfail(raises=AssertionError)
    def test_item_amount(self):
        self.a_mount = ItemsAmounts({'milk':-1})
        self._check.check_amount_over_0(self.a_mount.items)


class TestVendingMachine(unittest.TestCase):
    def setUp(self):
        self.vending = VendingMachine()

    def test_insert_coin(self):
        self.vending.insert_coin(50)
        self.assertEqual(self.vending._input.coin, 50)

    def test_insert_items(self):
        a = MachineInput({'milk':600})
        b = MachineInput({'water':500})


if __name__ == '__main__':
    unittest.main()