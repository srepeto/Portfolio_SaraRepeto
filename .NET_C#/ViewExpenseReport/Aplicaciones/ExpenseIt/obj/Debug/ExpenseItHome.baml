   M S B A M L   `   `   `  ����D  @ExpenseIt, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:ExpenseIt	ExpenseIt  5          ExpenseIt.ExpenseItHome   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      )localclr-namespace:ExpenseIt     5        N� Title$  ExpenseIt - Home��5	      .��5      � $��	0,0,0,0.4q�6    � 	Resources 5   
      ExpenseDataSource � XPath  nameItemTemplate �� XPath��%\  &	        &	     � 5      $ Expenses��68   .��5      �	�	<Expenses xmlns="">
                        <Person Name="Francisco Moreno" Department="Legal">
                            <Expense ExpenseType="Comida" ExpenseAmount="50€" />
                            <Expense ExpenseType="Transporte" ExpenseAmount="50€" />
                        </Person>
                        <Person Name="Eva María Marchena" Department="Marketing">
                            <Expense ExpenseType="Impresión de documento" ExpenseAmount="50€" />
                            <Expense ExpenseType="Regalo" ExpenseAmount="125€" />
                        </Person>
                        <Person Name="Antonio José García" Department="Ingeniería">
                            <Expense ExpenseType="Suscripción revista" ExpenseAmount="50€" />
                            <Expense ExpenseType="Nueva máquina" ExpenseAmount="600€" />
                            <Expense ExpenseType="Software" ExpenseAmount="500€" />
                        </Person>
                        <Person Name="Sara Repeto" Department="Finanzas">
                            <Expense ExpenseType="Cena" ExpenseAmount="100€" />
                        </Person>
                    </Expenses>        5$      �� 5'      .R�5(      �� ��6   �� $ @Name��5)      5+      ��5-   
   �� 5.       �� ImageSource$ fondo_adaptado.jpg��6    � ColumnDefinitions 51   
   �� 52      $	��230 �6   �� 53       � RowDefinitions 56   
   �� 57      �� 58      $
��Auto �6   �� 59      �� 5:      $
��Auto �6   .+�5?   
   �� $��1��6     headerTextStyle#��[ 6    ���	#FF2F8094$��Mostrar informe de gastos��6`   �� 5A   
   $��1��6   $��1��6!     listHeaderStyle#��[ 6.   ���	#FF215968._�5B      ��   listHeaderTextStyle#��[ 6   $��Nombres��6A   5C      �� 5D   
   -   5        $��peopleListBox��5D      $��1��6'   $��2��67   #��[ 5F   
   $��13(�6;   ��5E   
   ��  �� Source# [  $ Person��5G      �� 5J   
   -   5         ��Name$ 
botMostrar��5J      $��1��6%   $��3��65     buttonStyle#��[ 6W   $��Mostrar��6|   
����������	#FF215968��6�   Z� 6�   �� 5K   
   $��0��6   $��0��6    $��	logo2.png��6-   	 J� RenderTransformOrigin$	 0.536,2.166&�6@   $��60��6d   $	��Top=�6p   $
��Left=�6�   $��68��6�   $��	10,10,0,0q�6�   5L      5M      