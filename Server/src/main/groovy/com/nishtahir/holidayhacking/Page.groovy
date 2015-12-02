package com.nishtahir.holidayhacking;

import groovy.xml.MarkupBuilder;

class Page {
    static String newestMessage = ''

    static String createPage(Map queryParams) {
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        builder.html {
            h2 'Holiday hacking'
            form(action: 'dispatch'){
                input(type: 'text', name:'value')
                input(type: 'submit', value:'submit')
            }
            div(id: 'query-params') {
                if (!queryParams) li 'No query parameters given'
                else ul {
                    for (key in queryParams.keySet()) {
                        li "Query param: $key -> ${queryParams[key]}"
                        newestMessage = queryParams[key].toString();
                        newestMessage = newestMessage.replaceAll('\\[|\\]','')
                        println newestMessage
                    }
                }
            }
            p "Current date: ${new Date()}"
        }
        writer.toString()
    }
}
