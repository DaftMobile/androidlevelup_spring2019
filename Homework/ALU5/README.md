# Zajęcia nr 5 - praca domowa

## Opis

Zadanie polega na stworzeniu aplikacji, która spełni poniższe założenia:

- aplikacja ma wyświetlić powiadomienie nr 1 (szczegóły poniżej) zaraz po uruchomieniu telefonu
- po pierwszym uruchomieniu, aplikacja ma wyświetlić powiadomienie nr 2 (szczegóły poniżej) każdego dnia o godzinie 16:20 (wykorzystaj IntentService)
- po pierwszym uruchomieniu, aplikacja ma wyświetlić powiadomienie nr 3 (szczegóły poniżej) przy pierwszym podłączeniu do ładowarki, jeśli ma dostęp do internetu
- po uruchomieniu, aplikacja startuje foreground service z powiadomieniem nr 4
- przy każdym wzbudzeniu tego service'u wyświetlamy toast = "Scanning..."
- na głównym ekranie możemy wyłączyć foreground service poprzez kliknięcie w przycisk "stop scanning"

## Powiadomienia

powiadomienie nr 1:  
tytuł: Witaj ponownie!  
treść: Cieszymy się, że znowu jesteś z nami  
  
powiadomienie nr 2:  
tytuł: Familiada o 16:35 na TVP2  
treść: Nie przegap najlepszego programu rozrywkowego    
  
powiadomienie nr 3:  
tytuł: Obserwujemy Cię!  
treść: Ładowarka podłączona :)  
  
powiadomienie nr 4:  
tytuł: Skanowanie  
treść: Skanowanie beconów aktywne...  


## Termin
Projekt (spakowany albo podlinkowany z repo) zawierający rozwiązanie zadania należy wysłać na adres *android@daftacademy.pl* do **środy (10.04)** do godziny **12:00**. Powodzenia!
