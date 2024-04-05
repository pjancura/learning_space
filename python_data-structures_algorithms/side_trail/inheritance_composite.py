o = object()

print(dir(o))

class PayrollSystem:
    def calculate_payroll(self, employees):
        print("Calculating Payroll")
        print("===================")
        for employee in employees:
            print(f"Payroll for: {employee.id} - {employee.name}")
            print(f"- Check amount: {employee.calculate_payroll()}")
            print("")

class Employee:
    def __init__(self, id, name):
        self.id = id
        self.name = name     

class SalaryEmployee(Employee):
    def __init__(self, id, name, weekly_salary):
        super().__init__(id, name)
        self.weekly_salary = weekly_salary

    def calculate_payroll(self):
        return self.weekly_salary
    
class HourlyEmployee(Employee):
    def __init__(self, id, name, hours_worked, hourly_rate):
        super().__init__(id, name)
        self.hours_worked = hours_worked
        self.hourly_rate = hourly_rate

    def calculate_payroll(self):
        return self.hours_worked * self.hourly_rate
    
class CommissionEmployee(SalaryEmployee):
    def __init__(self, id, name, weekly_salary, commission):
        super().__init__(id, name, weekly_salary)
        self.commission = commission

    def calculate_payroll(self):
        fixed = super().calculate_payroll()
        return fixed + self.commission


if __name__ == "__main__":
    e = Employee(1234, "Horus")

    print(e.name)
    
    se = SalaryEmployee(1235, "Jimmy", weekly_salary=1000.00)
    print(se.weekly_salary)
    print(se.calculate_payroll())

    he = HourlyEmployee(1236, "Janice", hourly_rate=25.00, hours_worked=40)

    print(he.hourly_rate)
    print(he.calculate_payroll())

    ce = CommissionEmployee(1237, "Jorge", weekly_salary=1000.00, commission=250.00)

    print(ce.commission)
    print(ce.calculate_payroll())

    salary_employee = SalaryEmployee(1, "John Smith", 1500)
    hourly_employee = HourlyEmployee(2, "Jane Doe", 40, 15)
    commission_employee = CommissionEmployee(3, "Kevin Bacon", 1000, 250)

    payroll_system = PayrollSystem()
    payroll_system.calculate_payroll(
            [salary_employee, hourly_employee, commission_employee]
        )