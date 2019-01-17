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
    def __init__(self, _input):
        """ init

        Args:
            _input: string

        Returns:
            _output: numeric

        """
        self._input = _input
        self._output = 0

    @abstractmethod
    def get_input(self):
        raise NotImplemented('')

    @abstractmethod
    def insert_input(self, _input):
        raise NotImplemented('')

    @abstractmethod
    def check_input(self, _input):
        raise NotImplemented('')
    
    @abstractmethod
    def convert_input(self, _input):
        raise NotImplemented('')

    @abstractmethod
    def reset_output(self):
        raise NotImplemented('')

    @abstractmethod
    def merge_input(self):
        raise NotImplemented('')

class Calculator(PreProcess, metaclass=ABCMeta):
    """General Calculator
    """
    def __init__(self):
        self._input = None
        self._output = 0

    @abstractmethod
    def operator(self):
        raise NotImplemented('')

    def print_out(self):
        print(self._output)

    def run(self, _input):
        _in = self.get_input(_input)
        self.insert_input(_in)
        self.merge_input()
        self.operator()
        self.print_out()

class SingleCharCalculator(Calculator):
    """Single Char Calculator
    
    Example:
    You can calculate the string
        $ python main.py -i='5+5+5'
    """
    def __init__(self):
         super(SingleCharCalculator, self).__init__()

    def reset_output(self):
        self._input = []

    def get_input(self, _input):
        return _input
        
    def check_input(self, _input):
        assert isinstance(_input, str)

    def insert_input(self, _input):
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
        old_input = self.convert_input(str(self._output))
        new_input = self.convert_input(self._input)
        
        if reset:
            self.reset_output()
        else:
            new_input.extend(old_input)
        
        self._input = new_input

    def operator(self):
        self._output = sum(self._input)

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Calculator using Chars')
    parser.add_argument('-i', '--input', default='5,1,-6', type=str,
                    help='Character input')
    args = parser.parse_args()
    Cal = SingleCharCalculator()
    Cal.run(args.input)