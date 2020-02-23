import csv
import psycopg2

def create_schema(db):
    command = """
    CREATE TABLE movies (
      tconst varchar PRIMARY KEY,
      titletype varchar,
      primarytitle varchar,
      originaltitle varchar,
      isadult int,
      startYear int,
      endyear int,
      runtimeminutes int,
      genres varchar
    )
    """
    cur = db.cursor()
    cur.execute(command)
    cur.close()
    db.commit()

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

def insert_data(db):
    command = """
    INSERT INTO public.movies(
    	tconst, titletype, primarytitle, originaltitle, isadult, startyear, endyear, runtimeminutes, genres)
    	VALUES ('{}', '{}', '{}', '{}', {}, {}, {}, {}, '{}');
    """
    cur = db.cursor()
    with open("imdb_data.tsv", encoding='utf-8') as fd:
        rd = csv.reader(fd, delimiter="\t")
        next(rd)
        for row in rd:
            data = sanitize(row)
            if len(data) == 9:
                print(command.format(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]))
                cur.execute(command.format(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]))
    cur.close()
    db.commit()

def main():
    with psycopg2.connect(host="localhost",database="docker", user="admin", password="admin") as db:
        #create_schema(db)
        insert_data(db)

if __name__ == '__main__':
    main()