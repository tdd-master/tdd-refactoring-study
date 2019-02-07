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

from abc import ABCMeta, abstractmethod
import re
import argparse


class PreProcess(metaclass=ABCMeta):
    """General PreProcess
    """
    def __init__(self):
        """Init
        """
        pass

    @abstractmethod
    def check_input_type(self, _input):
        """Check the input
        """
        raise NotImplementedError('')

    @abstractmethod
    def insert_input_into_mem(self, _input):
        """Insert the input into memory
        """
        raise NotImplementedError('')

    @abstractmethod
    def convert_input(self, _input):
        """Convert the input to use operators such as sum, multiply, and so on
        """
        raise NotImplementedError('')

    @abstractmethod
    def reset_output_to_0(self):
        """Reset output
        Remove the previous output
        """
        raise NotImplementedError('')

    @abstractmethod
    def merge_input_output(self):
        """Merge input and output.
        """
        raise NotImplementedError('')


class Calculator(PreProcess, metaclass=ABCMeta):
    """General Calculator
    """
    def __init__(self):
        """Init
        """
        pass

    @abstractmethod
    def operator(self):
        """Operator
        """
        raise NotImplementedError('')

    def print_out(self):
        """Print the output
        """
        print(self._value[1])

    def run_preprocess(self, _input, reset):
        """Run preprocess"""
        self.insert_input_into_mem(_input)
        if reset:
            self.reset_output_to_0()
        self.merge_input_output()

    def run_operator(self):
        """Run operator"""
        self.operator()
        self.print_out()

    def run(self, _input, reset=True):
        """Run preprocess and operator
        """
        self.run_preprocess(_input, reset)
        self.run_operator()


class SingleCharCalculator(Calculator):
    """Single Char Calculator
    Example:
    You can calculate the string
        $ python main.py -i='5+5+5'
    """
    def __init__(self, sep):
        """
        Args:
            sep: string

        Returns:
            list: the first is input, the last is output
        """
        super(SingleCharCalculator, self).__init__()
        self._sep = sep
        self._value = [0, 0]

    def reset_output_to_0(self):
        """ Remove the previous output
        """
        self._value[1] = 0

    def get_input(self, _input):
        """Get the input
        """
        return _input

    def insert_input_into_mem(self, _input):
        """Insert the input as Chars
        """
        self.check_input_type(_input)
        self._value[0] = self.get_input(_input)

    def check_input_type(self, _input):
        """Check the input as Chars
        """
        self.check_input_type_is_str(_input)

    def convert_input(self, _input):
        return self.convert_input_string_to_list(_input)

    def check_input_type_is_str(self, _input):
        assert isinstance(_input, str)

    def convert_input_string_to_list(self, _input):
        """ convert input string into list.

        Args:
            _input: string

        Returns:
            list

        """
        pattern = r"[{}]".format("".join(self._sep))
        splited_input = re.split(pattern, _input)

        return [int(i) for i in splited_input]

    def merge_input_output(self):
        """Merge old_input(previous output) and new_input
        """
        old_input = self.convert_input(str(self._value[1]))
        new_input = self.convert_input(self._value[0])
        old_input.extend(new_input)
        self._value[0] = old_input

    def operator(self):
        """sum the list
        """
        self._value[1] = sum(self._value[0])


if __name__ == '__main__':
    PARSER = argparse.ArgumentParser(description='Calculator using Chars')
    PARSER.add_argument('-i', '--input', default='5,1,-6', type=str, help='Character input')
    ARGS = PARSER.parse_args()
    CAL = SingleCharCalculator(sep=[','])
    CAL.run(ARGS.input)
