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
import argparse


class PreProcess(metaclass=ABCMeta):
    """General PreProcess
    """
    def __init__(self):
        """Init
        """
        self._input = []
        self._output = []

    @abstractmethod
    def get_input(self, _input):
        """Get the input
        """
        raise NotImplementedError('')

    @abstractmethod
    def insert_input(self, _input):
        """Insert the input into memory
        """
        raise NotImplementedError('')

    @abstractmethod
    def check_input(self, _input):
        """Check the input
        """
        raise NotImplementedError('')

    @abstractmethod
    def convert_input(self, _input):
        """Convert the input to use operators such as sum, multiply, and so on
        """
        raise NotImplementedError('')

    @abstractmethod
    def reset_output(self):
        """Reset output
        Remove the previos output
        """
        raise NotImplementedError('')

    @abstractmethod
    def merge_input(self, reset=True):
        """Merge input and output.
        If reset is true, then reset the input
        """
        raise NotImplementedError('')


class Calculator(PreProcess, metaclass=ABCMeta):
    """General Calculator
    """
    def __init__(self):
        """Init
        """
        super(Calculator, self).__init__()
        self._input = 0
        self._output = 0

    @abstractmethod
    def operator(self):
        """Operator
        """
        raise NotImplementedError('')

    def print_out(self):
        """Print the output
        """
        print(self._output)

    def run_preprocess(self, _input):
        """Run preprocess"""
        _in = self.get_input(_input)
        self.insert_input(_in)
        self.merge_input()

    def run_operator(self):
        """Run operator"""
        self.operator()
        self.print_out()

    def run(self, _input):
        """Run preprocess and operator
        """
        self.run_preprocess(_input)
        self.run_operator()


class SingleCharCalculator(Calculator):
    """Single Char Calculator
    Example:
    You can calculate the string
        $ python main.py -i='5+5+5'
    """
    def __init__(self):
        super(SingleCharCalculator, self).__init__()
        self._input = 0
        self._output = 0

    def reset_output(self):
        """ Remove the previos output
        """
        self._input = []

    def get_input(self, _input):
        """Get the input
        """
        return _input

    def check_input(self, _input):
        """Check the input as Chars
        """
        assert isinstance(_input, str)

    def insert_input(self, _input):
        """Insert the input as Chars
        """
        self.check_input(_input)
        self._input = self.get_input(_input)

    def convert_input(self, _input):
        """ convert input string into list.

        Args:
            _input: string

        Returns:
            list

        """
        return [int(i) for i in _input.split(',')]

    def merge_input(self, reset=True):
        """Merge old_input(previous output) and new_input
        """
        old_input = self.convert_input(str(self._output))
        new_input = self.convert_input(self._input)

        if reset:
            self.reset_output()
        else:
            new_input.extend(old_input)

        self._input = new_input

    def operator(self):
        """sum the list
        """
        self._output = sum(self._input)


if __name__ == '__main__':
    PARSER = argparse.ArgumentParser(description='Calculator using Chars')
    PARSER.add_argument('-i', '--input', default='5,1,-6', type=str, help='Character input')
    ARGS = PARSER.parse_args()
    CAL = SingleCharCalculator()
    CAL.run(ARGS.input)
