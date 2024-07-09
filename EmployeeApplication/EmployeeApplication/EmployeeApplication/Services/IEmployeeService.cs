using EmployeeApplication.Models;
using System.Security.Cryptography;

namespace EmployeeApplication.Services
{
	public interface IEmployeeService
	{
		void AddEmployee(Employee employee);

		void DeleteEmployee(int id);

		List<Employee> GetAll();

		Employee GetEmployeeById(int id);

        void UpdateEmployee(Employee employee);

		List<Employee> Sort();
    }

}
