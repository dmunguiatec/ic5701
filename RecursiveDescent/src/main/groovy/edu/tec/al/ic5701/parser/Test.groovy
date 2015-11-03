package edu.tec.al.ic5701.parser

import edu.tec.al.ic5701.lexer.ListLexer

/**
 *   RDLexer
 *   Copyright (C) 2015  diegomunguia
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License along
 *   with this program; if not, write to the Free Software Foundation, Inc.,
 *   51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

def code = '[x, 1, y, 1024]'
Parser parser = new ListParser(new ListLexer(new StringReader(code)))
parser.list()
println(parser.ast)

code = '[[x, 1],[y, 2],[z, 3]]'
parser = new ListParser(new ListLexer(new StringReader(code)))
parser.list()
println(parser.ast)

try {
    code = '[[x, 1],[y, -2]]'
    parser = new ListParser(new ListLexer(new StringReader(code)))
    parser.list()
} catch(Exception e) {
    println("${e.class.name}: ${e.message}")
}

try {
    code = '[[x, 1] [y]]'
    parser = new ListParser(new ListLexer(new StringReader(code)))
    parser.list()
} catch(Exception e) {
    println("${e.class.name}: ${e.message}")
}


