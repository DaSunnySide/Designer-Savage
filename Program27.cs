//From the microsoft Docs, a simple part of a console application that initializes a speech synthesizer object
//Some important things to note when using the Microsoft text to speech:
//There are several voices you can select and use to play sound in. The voices vary a lot depending
//on region, so you can have voices that cater to your clientele if your webservice is international.
//Multiple languages are also supported, enabling you to reach more clients, provided you can type your
//material in that language.

using System;  
using System.Speech.Synthesis;  
  
namespace SampleSynthesis  
{  
  class Program  
  {  
    static void Main(string[] args)  
    {  
  
      // Initialize a new instance of the SpeechSynthesizer.  
      SpeechSynthesizer synth = new SpeechSynthesizer();  
  
      // Configure the audio output. This is important because if you skip this step, no sound will be heard.   
      synth.SetOutputToDefaultAudioDevice();  
  
      // Speak a string. Pretty basic, but you can put anything you want here.
      synth.Speak("This example demonstrates a basic use of Speech Synthesizer");  
  
      Console.WriteLine();  
      Console.WriteLine("Press any key to exit...");  
      Console.ReadKey();  
    }  
  }  
}
