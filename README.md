# Software Engineering - Übung 1
## 1. Frage
**Wie können Sie unter Berücksichtigung der Prinzipien des objektorientierten Entwurfs dafür sorgen, dass der Code, der den beiden Implementierungen gemeinsam ist, nicht dupliziert wird?**

Insgesamt gibt es drei Möglichkeiten, um Duplikation zu vermeiden:
1. **Komposition**: Man platziert den gemeinsamen Code in einer separaten Klasse und verwendet diese Klasse in den beiden Implementierungen.
2. **Vererbung**: Ähnlich wie bei der Komposition, jedoch leitet man die spezifischen Implementierungen von dieser Klasse ab.
3. **Interfaces**: Man deklariert ein Interface mit den gemeinsamen Methoden und implementiert dieses Interface in den verschiedenen Implementierungen.


## 2. Frage
**Wie kann die Objekterzeugung mit Hilfe einer zusätzlichen Klasse durchgeführt werden? In welchem Package sollte diese zusätzliche Klasse liegen?**

Die Objekterzeugung kann durch eine Factory-Klasse/-Methode realisiert werden. Diese Klasse sollte im selben Package wie das zu erzeugende Objekt liegen.

## 3. Frage
**Welches Entwurfsmuster liegt für diesen Anwendungsfall nahe? Welchen Vorteil bringt die Nutzung dieses Entwurfsmusters?**

Für diesen Anwendungsfall liegt ein Creational Pattern "Erstellungsmuster" nahe. Dieses Entwurfsmuster bietet die Möglichkeit, Objekte situationsgerecht und den Bedürfnissen des Systems entsprechend zu erstellen.

## 4. Frage
**Warum sollten Testfälle in einer separaten Test-Klasse implementiert werden?**

Durch die Implementierung von Testfällen in separaten Klassen wird der Produktionscode vom Testcode getrennt. Diese klare Trennung erleichtert das Codeverständnis und die Wartung.

## 5. Frage
**Wozu dienen die Äquivalenzklassen im Blackbox-Test?**

Äquivalenzklassen im Blackbox-Test dienen dazu, Eingabedaten in Gruppen zu unterteilen, um effizientere und effektivere Tests durchführen zu können. Die Grundidee ist, nur einen Vertreter aus jeder Klasse zu testen, da jede Äquivalenzklasse ähnliche Verhaltensweisen des Systems aufweist.

## 6. Frage
**Warum lässt sich für die Klasse Client nicht ohne weiteres ein Blackbox-Test umsetzen?**
Die Klasse Client hat keine Ausgabewerte und wodurch Repräsentanten nicht einfach ermittelt/geprüft werden können.
