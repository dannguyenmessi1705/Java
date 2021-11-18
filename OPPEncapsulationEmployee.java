class OPPEncapsulationEmployee {
        private int id;
        private String firstName;
        private String lastName;
        private int salary;
        public OPPEncapsulationEmployee(int id, String firstName, String lastName, int salary){
            this.id=id;
            this.firstName=firstName;
            this.lastName=lastName;
            this.salary=salary;
        }
        public int getId(){
            return id;
        }
        public int getSalary(){
            return salary;
        }
        public String getFirstName(){
            return firstName;
        }
        public String getLastName(){
            return lastName;
        }
        public String getFullName(){
            return firstName+" "+lastName;
        }
        public void setId(int id){
            this.id=id;
        }
        public void setSalary(int salary){
            this.salary=salary;
        }
        public void setFirstName(String firstName){
            this.firstName=firstName;
        }
        public void setLastName(String lastName){
            this.lastName=lastName;
        }
        public static void main(String[]args) {
            OPPEncapsulationEmployee e=new OPPEncapsulationEmployee(1705, "Dan", "Nguyen", 30000000);
            System.out.println("ID: "+e.getId());
            System.out.println("Full Name: "+e.getFullName());
            System.out.println("Salary: "+e.getSalary());
        }
    }
