SEDA BLAST plugin [![license](https://img.shields.io/badge/LICENSE-GPLv3-blue.svg)]()
=================================
SEDA (SEquence DAtaset builder) is an open source application for processing FASTA files containing DNA and protein sequences. Please, visit the [official web page](http://www.sing-group.org/seda) of the project for downloads, manuals and support.

This plugin allows the possibility of executing BLAST analyses trough the SEDA Graphical User Interface. In short, this plugin provides an operation that allows you to perform different BLAST queries using the selected FASTA files. Regarding the database to use in the queries, there are two possible modes: querying against all the selected FASTA files or querying against each FASTA file separately. Regarding the query, there are also to possibilities: using the sequences in one of the selected FASTA as queries or using the sequences in an external FASTA file as queries. Within this operation, one blast query is executed for each sequence in the FASTA file.

![SEDA BLAST Operation Screenshot](seda-screenshot.png)