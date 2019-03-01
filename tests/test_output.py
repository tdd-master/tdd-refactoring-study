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

class TestInputItem(unittest.TestCase):
    def setUp(self):
        self.Items = MachineInputItem({'milk' : 600})
        self.Check = CheckVaild()
        self.key = 'milk'

    @pytest.mark.xfail(raises=AssertionError)
    def test_input_less_than_value(self):
        self.Check.check_coin_value(500, self.Items.items.get('milk'))

class TestItem(unittest.TestCase):
    def setUp(self):
        self.item_01 = MachineInputItem({'milk':600})
        self.item_02 = MachineInputItem({'water':500})
        self.Check = CheckVaild()

    def test_add(self):
        self.item_01.add_new_items(self.item_02)
        self.assertEqual(list(self.item_01.items.keys()), ['milk', 'water'])

    @pytest.mark.xfail(raises=AssertionError)
    def test_item_amount(self):
        self.item_01 = MachineInputItem({'milk':-1})
        self.Check.check_amount_over_0(self.item_01.items)

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