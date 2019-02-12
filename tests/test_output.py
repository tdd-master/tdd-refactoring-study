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
from main import MachineInput, MachineOutput

class TestOutPut(unittest.TestCase):
    def setUp(self):
        self.key = 'milk'
        self.selected_items = {'milk' : 500}
        self.change = 300
        self.out = MachineOutput(self.change, self.selected_items, self.key)

    def test_print_change(self):
        print(self.out)

class TestInput(unittest.TestCase):
    def setUp(self):
        self.coin = 400
        self.key = 'milk'
        self.selected_items = {'milk' : 500}
        self.INPUT = MachineInput()

    @pytest.mark.xfail(raises=AssertionError)
    def test_input_less_than_value(self):
        self.INPUT.check_coin_item(self.coin, self.selected_items.get(self.key))


if __name__ == '__main__':
    unittest.main()