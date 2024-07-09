using EmployeeApplication.Models;

namespace EmployeeApplication.Repositories
{
	public interface IEmployeeManager
	{
		void AddEmployee(Employee employee);

		void DeleteEmployee(int id);
	
		List<Employee> GetAll();

		Employee GetEmployeeById(int id);

		void UpdateEmployee(Employee employee);

		List<Employee> Sort();

	}

}
