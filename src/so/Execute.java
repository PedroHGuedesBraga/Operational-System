package so;

public class Execute {
    public static void main(String[] args) {
    	System.out.println("*** Processo p1*****");
    	Process p1 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS,20);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p1);    
        System.out.println();
        System.out.println("*** Processo p2*****");
        Process p2 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS,14 );
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p2); 
   
       
    }
}
