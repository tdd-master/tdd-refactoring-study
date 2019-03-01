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
from check_vaild import CheckVaild
from main import MachinePrintOutput, MachineInputItem, MachineInput, \
                 CustomerInput, MachineCalcluator, VendingMachine

class TestOutPut(unittest.TestCase):
    def setUp(self):
        self.coin = 1000
        self.items = {'milk':600, 'water':500}
        self.key = 'milk'
        self.Print = MachinePrintOutput()

    def test_print_main_monitor(self):
        self.assertTrue(isinstance(self.Print.print_main_monitor(self.items, self.key), str))

    def test_print_coin_monitor(self):
        self.assertTrue(isinstance(self.Print.print_coin_monitor(self.coin), str))

    def test_print_end_monitor(self):
        self.assertTrue(isinstance(self.Print.print_end_monitor(), str))

class TestItemAmount(unittest.TestCase):
    def setUp(self):
        self.ItemsAmount = MachineInputItem({'milk':2})
        self.Check = CheckVaild()

    def test_add_new_items(self):
        self.ItemsAmount.add_new_items({'water': 3})
        self.assertEqual(list(self.ItemsAmount.items.keys()), ['milk', 'water'])

    def test_sub_items(self):
        self.ItemsAmount.sub_items('milk')
        self.assertEqual(list(self.ItemsAmount.items.keys()), [])

    def test_modify_value(self):
        key = 'milk'
        self.ItemsAmount.set_value_by_key(key, 100)
        self.assertEqual(self.ItemsAmount.items[key], 100)

    def test_remove_all_items(self):
        self.ItemsAmount.remove_all_items()
        self.assertEqual(list(self.ItemsAmount.items.keys()), [])

    @pytest.mark.xfail(raises=AssertionError)
    def test_item_amount(self):
        self.ItemsAmount_01 = MachineInputItem({'milk':-1})
        self.Check.check_amount_over_0(self.ItemsAmount_01.items)


class TestInputItemValue(unittest.TestCase):
    def setUp(self):
        self.ItemsValue = MachineInputItem({'milk':600})
        self.Check = CheckVaild()
        self.key = 'milk'

    def test_add_new_items(self):
        self.ItemsValue.add_new_items({'water':500})
        self.assertEqual(list(self.ItemsValue.items.keys()), ['milk', 'water'])

    def test_sub_items(self):
        self.ItemsValue.sub_items('milk')
        self.assertEqual(list(self.ItemsValue.items.keys()), [])

    def test_modify_value(self):
        key = 'milk'
        self.ItemsValue.set_value_by_key(key, 100)
        self.assertEqual(self.ItemsValue.items[key], 100)

    def test_remove_all_items(self):
        self.ItemsValue.remove_all_items()
        self.assertEqual(list(self.ItemsValue.items.keys()), [])

    @pytest.mark.xfail(raises=AssertionError)
    def test_input_less_than_value(self):
        self.Check.check_coin_value(500, self.ItemsValue.items.get('milk'))

class TestInputCoin(unittest.TestCase):
    def setUp(self):
        self.Coin = MachineInputCoin({'100', 0, '500', 0, '1000', 0})

class TestVendingMachine(unittest.TestCase):
    def setUp(self):
        self.Vending = CustomerInput()

    def test_insert_coin(self):
        self.Vending.insert_coin(50)
        self.assertEqual(self.Vending.coin, 50)

    def test_insert_items(self):
        a = MachineInputItem({'milk':600})
        b = MachineInputItem({'water':500})


if __name__ == '__main__':
    unittest.main()