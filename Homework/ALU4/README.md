# Zajęcia nr 4 - praca domowa

## Opis
Zadanie polega na modyfikacji załączonego projektu, tak aby dodać do bazy danych informację o studiu filmowym, które wyprodukowało każdy nowododawany film.
Części związane z UI i domeną (pakiety `.view` oraz `.entity`) zostały już dostosowane do nowych wymagań, Waszym zadaniem jest przerobienie warstwy bazy danych (pakiet `.database`).
W projekcie znajdziecie także encje `Movie` i `Studio` zgodne z nowym schematem.
**Uwaga!** W związku z powyższymi zmianami, dołączony projekt się nie kompiluje!

### Wymagania
* Encje `Movie` i `Studio` mają pozostawać w relacji N:1
* Encji `Movie` i `Studio` nie należy modyfikować (dopuszczalne jest dopisanie do nich kodu)
* Nie można utworzyć domyślnego studia, do którego "wpadną" niedookreślone filmy
* Każdy nowododany film musi być przypisany do studia
* Filmy pobierane z assetów nie muszą mieć studia (pole jest nullowalne w domenowym modelu `Movie`)

### Wskazówki
Metoda z adnotacją `@Insert` może zwrócić `Long` lub `LongArray` z ID stworzonych rekordów - wystarczy tylko zadeklarować w DAO taki typ zwracany.  
[Ta sekcja](https://developer.android.com/training/data-storage/room/defining-data#object-relationships) przewodników dla developerów opisuje użycie kluczy obcych.
[Ta sekcja natomiast](https://developer.android.com/training/data-storage/room/accessing-data#query-multiple-tables) wyjaśnia, jak łączyć dane z wielu tabel w jednym query.
Polecam także adnotacje `@Embedded` i `@Relation`. Nie są konieczne do rozwiązania, ale mogą pomóc.

## Termin
Projekt (spakowany albo podlinkowany z repo) z rozwiązaniem należy wysłać na adres *android@daftacademy.pl* do **środy (03.04)** do godziny **12:00**. Powodzenia!

