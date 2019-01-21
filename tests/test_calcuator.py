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
       self.test_chars = ['0', '1,2', '1,2,3']
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

    def test_convert_input(self):
        test_input_dot = '5.7.7'
        test_input_plus = '5+7+7'
        test_input_plus_dot = '5+7,7'
        test_ouput = [5,7,7]
        self.Cal_plus = SingleCharCalculator(sep=['+'])
        self.assertTrue(test_ouput, self.Cal_plus.convert_input(test_input_plus))

        self.Cal_dot = SingleCharCalculator(sep=['.'])
        self.assertTrue(test_ouput, self.Cal_dot.convert_input(test_input_dot))
        
        self.Cal_plus_dot = SingleCharCalculator(sep=['+', ','])
        self.assertTrue(test_ouput, self.Cal_plus_dot.convert_input(test_input_plus_dot))

    def test_reset_output(self):
        self.Cal.reset_output()
        self.assertEqual(self.Cal._input, [])

    def test_merge_input(self):
        self.Cal.insert_input('3')
        self.Cal.merge_input()
        self.assertEqual(self.Cal._input, [3])

    def test_operator(self):
        self.Cal.insert_input('3, 3')
        self.Cal.merge_input()
        self.Cal.operator()
        self.assertEqual(self.Cal._input, [3, 3])
        self.assertEqual(self.Cal._output, 6)

    def test_loop_operator(self):
        self.Cal.insert_input('3, 3')
        self.Cal.merge_input()
        self.Cal.operator()
        self.assertEqual(self.Cal._output, 6)
        
        self.Cal.insert_input('6, 3')
        self.Cal.merge_input(reset=False)
        self.Cal.operator()
        self.assertEqual(self.Cal._output, 6+6+3)

    def test_task_input_output(self):
        for i,j in zip(self.test_chars, self.test_answer):
            self.Cal.run(i)
            self.assertEqual(self.Cal._output, j)

if __name__ == '__main__':
    unittest.test()