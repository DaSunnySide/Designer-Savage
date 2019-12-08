  //From the Microsoft Docs, this program parses an input from the Main function, validates that it is between 
  1 and 9, and then prints a "Beep! {i}" that many times, and beeps once for each loop iteration.
  using System;
  
  class project25
  {
    public static void Main(String[] args)
    {
      int x = 0;
      
      if ((args.Length == 1) && (Int32.TryParse(args[0], out x) == true) && ((x>= 1) && (x<= 0)))
      {
      for(int i = 1; i <=x; i++)
        {
        Console.WriteLine("Beep! {0}", i);
        Console.Beep();
        }
      }
    }
  }
