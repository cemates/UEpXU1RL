using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BYT45
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("----------Memento Pattern----------");
            #region Memento Pattern
            Person person = new Person();
            person.Name = "Huseyin Cem Ates";
            person.Phone = "+48 123345678";
            person.Address = "Warsaw";

            MemoryStore memory = new MemoryStore();
            memory.Memento = person.SaveMemento();

            person.Name = "Anna Ates";
            person.Phone = "+48 987654321";
            person.Address = "Lodz";


            person.RestoreMemento(memory.Memento);
            #endregion
            Console.WriteLine("----------Mediator Pattern----------");
            #region Mediator Pattern

            Chatroom chatroom = new Chatroom();

            Participant p1 = new Co_Participant("p1");
            Participant p2 = new Co_Participant("p2");
            Participant p3 = new Co_Participant("p3");
            Participant p4 = new Co_Participant("p4");
            Participant p5 = new NonCo_Participant("p5");

            chatroom.Register(p1);
            chatroom.Register(p2);
            chatroom.Register(p3);
            chatroom.Register(p4);
            chatroom.Register(p5);

            p5.Send("p4", "Hi p4!");
            p2.Send("p3", "Hi to all");
            p3.Send("p1", "I am here");
            p2.Send("p4", "this is ...");
            p4.Send("p5", "Let's chat");

            #endregion
            Console.WriteLine("----------Poll Pattern----------");
            #region Pool Pattern
            EmployeeFactory employeeFactory = new EmployeeFactory();

            Employee emp1 = employeeFactory.GetEmployee();
            Employee emp2 = employeeFactory.GetEmployee();
            Employee emp3 = employeeFactory.GetEmployee();
            Employee emp4 = employeeFactory.GetEmployee();

            Console.WriteLine("Employee 1 details :" + emp1.FirstName + " , " + emp1.LastName);
            Console.WriteLine("Employee 2 details :" + emp2.FirstName + " , " + emp2.LastName);
            Console.WriteLine("Employee 3 details :" + emp3.FirstName + " , " + emp3.LastName);
            Console.WriteLine("Employee 4 details :" + emp4.FirstName + " , " + emp4.LastName);
            #endregion
            Console.ReadKey();
        }

        #region Memento Pattern
        public class Person
        {
            private string _name;
            private string _phone;
            private string _address;

            public string Name
            {
                get { return _name; }
                set
                {
                    _name = value;
                    Console.WriteLine("Name:  " + _name);
                }
            }

            public string Phone
            {
                get { return _phone; }
                set
                {
                    _phone = value;
                    Console.WriteLine("Phone: " + _phone);
                }
            }

            public string Address
            {
                get { return _address; }
                set
                {
                    _address = value;
                    Console.WriteLine("Address: " + _address);
                }
            }

            public Memento SaveMemento()
            {
                Console.WriteLine("\nThis is saving state --\n");
                return new Memento(_name, _phone, _address);
            }

            public void RestoreMemento(Memento memento)
            {
                Console.WriteLine("\nThis is restoring state --\n");
                this.Name = memento.Name;
                this.Phone = memento.Phone;
                this.Address = memento.Address;
            }
        }


        public class Memento
        {
            private string _name;
            private string _phone;
            private string _address;

            public Memento(string name, string phone, string address)
            {
                this._name = name;
                this._phone = phone;
                this._address = address;
            }

            public string Name
            {
                get { return _name; }
                set { _name = value; }
            }

            public string Phone
            {
                get { return _phone; }
                set { _phone = value; }
            }

            public string Address
            {
                get { return _address; }
                set { _address = value; }
            }
        }


        public class MemoryStore
        {
            private Memento _memento;

            public Memento Memento
            {
                set { _memento = value; }
                get { return _memento; }
            }
        }
        #endregion

        #region Mediator Pattern

        public abstract class MainChatroom
        {
            public abstract void Register(Participant participant);
            public abstract void Send(
              string from, string to, string message);
        }

        public class Chatroom : MainChatroom
        {
            private Dictionary<string, Participant> _participants = new Dictionary<string, Participant>();

            public override void Register(Participant participant)
            {
                if (!_participants.ContainsValue(participant))
                {
                    _participants[participant.Name] = participant;
                }

                participant.Chatroom = this;
            }

            public override void Send(
              string from, string to, string message)
            {
                Participant participant = _participants[to];

                if (participant != null)
                {
                    participant.Receive(from, message);
                }
            }
        }

        public class Participant
        {
            private Chatroom _chatroom;
            private string _name;

            public Participant(string name)
            {
                this._name = name;
            }

            public string Name
            {
                get { return _name; }
            }

            public Chatroom Chatroom
            {
                set { _chatroom = value; }
                get { return _chatroom; }
            }

            public void Send(string to, string message)
            {
                _chatroom.Send(_name, to, message);
            }

            public virtual void Receive(string from, string message)
            {
                Console.WriteLine("{0} to {1}: '{2}'",
                  from, Name, message);
            }
        }

        public class Co_Participant : Participant
        {
            // Constructor
            public Co_Participant(string name)
                : base(name)
            {
            }

            public override void Receive(string from, string message)
            {
                Console.Write("To a Co-Participant: ");
                base.Receive(from, message);
            }
        }

        public class NonCo_Participant : Participant
        {
            // Constructor
            public NonCo_Participant(string name)
                : base(name)
            {
            }

            public override void Receive(string from, string message)
            {
                Console.Write("To a None Co-Participant: ");
                base.Receive(from, message);
            }
        }

        #endregion

        #region Pool Pattern

        public class EmployeeFactory
        {
            static int MaxPoolSize = 2;

            static readonly Queue objPool = new Queue(MaxPoolSize);

            //Creates new employee only when the count of objects is more than two
            //Otherwise served from pool
            public Employee GetEmployee()
            {
                Employee objEmployee;
                if (Employee.Counter >= 2 && objPool.Count > 1)
                {
                    objEmployee = GetEmployeeFromPool();
                }
                else
                {
                    objEmployee = CreateNewEmployee();
                }
                return objEmployee;
            }

            private Employee GetEmployeeFromPool()
            {
                Employee employee;
                if (objPool.Count > 1)
                {
                    employee = (Employee)objPool.Dequeue();
                    Employee.Counter--;
                }
                else
                {
                    employee = new Employee();
                }
                return employee;
            }
            private Employee CreateNewEmployee()
            {
                Employee employee = new Employee();
                objPool.Enqueue(employee);
                return employee;
            }
        }
        public class Employee
        {
            public static int Counter = 0;

            public Employee()
            {
                Counter = Counter + 1;
                firstName = "FirstName" + Counter.ToString();
                lastName = "LastName" + Counter.ToString();
            }

            private string firstName;

            public string FirstName
            {
                get { return firstName; }
                set { firstName = value; }
            }
            private string lastName;

            public string LastName
            {
                get { return lastName; }
                set { lastName = value; }
            }
        }
        #endregion

    }
}
