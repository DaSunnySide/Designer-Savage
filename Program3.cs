using System;

namespace ConsoleApp1
{
    class Program3
    {
        static void Main(string[] args)
        {
            //request User input with file name, save it as a string, and open the file.
            Console.WriteLine("Enter file name");
            string input = Console.ReadLine();
            string text = System.IO.File.ReadAllText(input);
            Console.WriteLine(text);



        }
    }
}
