<!DOCTYPE html>
<html>
    <head>
        <title>Show Ausgaben</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    
    <body>

        <h2>Liste der Ufa-Revue Ausgaben</h2>
        
        <table>
            <tr>
                <th>Id</th>  
                <th>Jahr</th>  
                <th>Bezeichnung</th>
            </tr>        

            <#list ausgaben as ausgabe>
                <tr>
                    <td>${ausgabe.id}</td> 
                    <td>${ausgabe.jahr}</td> 
                    <td>${ausgabe.bezeichnung}</td>
                </tr>
            </#list>        
        </table>     
    </body>
</html> 