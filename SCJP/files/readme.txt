1. rezulat operacji na int, byte, char, lub shortach to zawsze int
2. deserializacja gdzy super nie implementuje Serializable 
to nie jest deserializowany - przyjmuje wartoœci z inicjalizacji, kontrukcji - 
w taki przypadku gdy klasa nie posiada kontruktora bezparametrowego wyleci wyj¹tek
