
## 1. Frage (Wie können Sie unter Berücksichtigung der Prinzipien des objektorientierten Entwurfs dafür sorgen, dass der Code, der den beiden Implementierungen gemeinsam ist, nicht dupliziert wird?):

Insgesamt gibt es drei Möglichkeiten, die eine wäre Komposition, dabei platziert man den gemeinsamen Code in einer separaten Klasse, und verwendet dann die Klasse in den beiden Implementierungen. Eine andere wäre es, genauso wie bei der ersten Möglichkeit vorzugehen, nur dass man dann die spezifischen Implementierungen von dieser Klasse ableitet. Die letzte Möglichkeit arbeitet mit Interfaces, hierbei würden wir ein Interface mit den gemeinsamen Methoden deklarieren und dann das Interface in die Implementierungen implementieren.  
## 2. Frage (Wie kann die Objekterzeugung mit Hilfe einer zusätzlichen Klasse durchgeführt werden? In welchem Package sollte diese zusätzliche Klasse liegen?):

Durch das erzeugen einer Factory kann die Objekterzeugung durchgeführt werden.
Die Klasse sollte in dem selben Package wie das zu erzeugende Objekt liegen. 
## 3. Frage (Welches Entwurfsmuster liegt für diesen Anwendungsfall nahe? Welchen Vorteil bringt die Nutzung dieses Entwurfsmusters?):

Für diesen Anwendungsfall liegt ein Creational Pattern "Erstellungsmuster" nahe. Dieses Entwurfsmuster bietet die Möglichkeit, Objekte so zu erstellen, die der Situation und auch den Bedürfnissen des Systems entsprechen. 
## 4. Frage (Warum sollten Testfälle in einer separaten Test-Klasse implementiert werden?):

Durch die Implementierung von Testfällen in separaten Klassen trennt man den Produktionscode vom Testcode. Diese klare Trennung ermöglicht es das Codeverständnis und die jeweilige Wartung des Codes zu erleichtern. 
## 5. Frage (Wozu dienen die Äquivalenzklassen im Blackbox-Test?):

Äquivalenzklassen im Blackbox-Test dienen um Eingabedaten in Gruppen oder Klassen zu unterteilen um dadurch wiederum effizientere und effektivere Tests durchzuführen. Die Grundidee ist nur einen Vertreter aus jeder Klasse zu testen, da jede Äquivalenzklasse ähnliche Verhaltensweisen des Systems aufweist. 
## 6. Frage (Warum lässt sich für die Klasse Client nicht ohne weiteres ein Blackbox-Test umsetzen?):

Die Klasse Client hat keine Ausgabewerte, wodurch nicht Repräsentanten ermittelt werden können, die für einen Blackbox-Text ausschlaggebend sind. 

