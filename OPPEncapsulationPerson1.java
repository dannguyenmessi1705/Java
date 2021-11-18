class OPPEncapsulationPerson1 {
        private int id;
        private String name;
        private int age;
        private String address;
        public OPPEncapsulationPerson1(int a, String b, int c, String d){
            this.id=a;
            this.name=b;
            this.age=c;
            this.address=d;
        }
        public int getId(){
            return id;
        }
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public String getAddress(){
            return address;
        }	
        public static void main(String[] args) {
            OPPEncapsulationPerson1 p=new OPPEncapsulationPerson1(1001, "Quynh", 24, "Ha Noi");
            System.out.println("Id: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Age: " + p.getAge());
            System.out.println("Address: " + p.getAddress());
        }
    }
