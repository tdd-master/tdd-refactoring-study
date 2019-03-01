class CheckVaild:
    def __init__(self):
        pass

    def check_coin_value(self, coin, value):
        assert coin > value

    def check_amount_over_0(self, items):
        def print_amount_error(value):
            assert value >= 0, "Mount must be >= 0"

        for key, value in items.items():
            if value < 0:
                print_amount_error(value)
