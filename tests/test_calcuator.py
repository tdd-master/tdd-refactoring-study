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
"""Test For Calculator using string"""

import unittest
from main import SingleCharCalculator
        
class TestCharCalculator(unittest.TestCase):
    def setUp(self):
       self.test_chars = ['0', '1,2', '1,2\n3']
       self.test_answer = [0, 3, 6]
       self.Cal = SingleCharCalculator()
    
    def test_get_input(self):
        output = self.Cal.get_input('0')
        self.assertEqual(output, '0')

    def test_check_input_numeric(self):
        _in = self.Cal.get_input(5)
        try:
            self.Cal.check_input(_in)
        except AssertionError as E:
            self.assertTrue(isinstance(E, AssertionError))

    def test_check_input_chars(self):
        input_value = self.Cal.get_input('5')
        self.Cal.check_input(input_value)
        
    def test_reset_input(self):
        self.Cal.reset_input()
        self.assertEqual(self.Cal._input, [])

    def test_merge_input(self):
        self.Cal.insert_input('3')
        self.Cal.merge_input('6', reset=False)
        self.assertEqual(self.Cal._input, [3, 6])

if __name__ == '__main__':
    unittest.test()