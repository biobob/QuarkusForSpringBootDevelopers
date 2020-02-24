import csv
import requests
import gzip

# SANITIZING... removing ' and \n from tsv file
def sanitize(row):
    array = []
    for data in row:
        if data != '\\N':
            array.append(data.replace("'", ""))
        else:
            array.append('null')
    array[0] = array[0]
    return array

def download_data():
    url = 'https://datasets.imdbws.com/title.basics.tsv.gz'
    myfile = requests.get(url)
    open('title.basics.tsv.gz', 'wb').write(myfile.content)
    with gzip.open("title.basics.tsv.gz", "rb") as f:
        with open("imdb_data.tsv", "wb") as file:
            file.write(f.read())


# FILTERING... including just movies and not adult movies
def filter(row):
    array = [None for _ in range(5)]
    id = row[0][2:]
    if (row[1] != 'movie' and row[4] != 0) or row[5] == 'null':
        return []
    array[0] = int(id)             #ID
    array[1] = row[2]              #Title
    array[2] = int(row[5])         #Year
    array[3] = row[7]              #length
    array[4] = row[8]              #genres
    return array

def create_schema(file):
    command = "CREATE TABLE movies (id int PRIMARY KEY UNIQUE, title varchar, year int, length int, genres varchar);"
    file.write(command)

def insert_data(file):
    command = "INSERT INTO public.movies(id, title, year, length, genres) VALUES ({}, '{}', {}, {}, '{}');"
    with open("imdb_data.tsv", encoding='utf-8') as fd:
        rd = csv.reader(fd, delimiter="\t")
        next(rd)
        for row in rd:
            data = sanitize(row)
            data = filter(data)
            if len(data) == 5:
                print(command.format(data[0], data[1], data[2], data[3], data[4]))
                file.write(command.format(data[0], data[1], data[2], data[3], data[4]))

def main():
    download_data()
    with open("import.sql", "w", encoding='utf-8') as file:
        create_schema(file)
        insert_data(file)

if __name__ == '__main__':
    main()