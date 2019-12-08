//A goofy program that takes user input from the command line, and prints out a statement followed by a beep htat many times.
using System;

class Sample 
{
    public static void Main(String[] args) 
    {
    int x = System.Console.ReadLine();
      for (int i = 1; i <= x; i++)
          {
          Console.WriteLine("Beep number {0}.", i);
          Console.Beep();
          }
      }
}
