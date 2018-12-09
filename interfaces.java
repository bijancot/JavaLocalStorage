public class interfaces{
    public static void main(String[] args){
        func_Gson.GetGSON();
        func_Gson.AddGSON("Panji", "0895326927698", "GPA", "Nji", "panjidia995@gmail.com");
        //func_Gson.AddGSON("Panjo", "0895326927698", "GPA", "Nji", "panjidia995@gmail.com");
        //func_Gson.GetGSON();
       func_Gson.RemoveGSON("Panji");
       System.out.println("---------------------------------------\n");
       func_Gson.GetGSON();
    }
}