   M S B A M L   `   `   `  ����D  @ExpenseIt, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:ExpenseIt	ExpenseIt  5      !    ExpenseIt.ExpenseReportPage   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      )localclr-namespace:ExpenseIt     5        N� Title$  ExpenseIt - View Expense��5	      .��5      � $��	0,0,0,0.4q�6    � 	Resources 5   
      typeItemTemplate �� XPath  amountItemTemplate��%�   &	        &	 I     �� 5      .R�5      �� ��6   �� $ @ExpenseType��5      �� 5      .R�5      �� ��6   �� $ @ExpenseAmount��5      5      ��5   
   �� 5       �� ImageSource$ fondo_adaptado.jpg��6    � ColumnDefinitions 5   
   �� 5      $	��230 �6   �� 5       � RowDefinitions 5    
   �� 5!      $
��Auto �6   $
��72.8��6*   �� 5"      .+�5&   
   �� $��1��6     headerTextStyle#��[ 6    ���	#FF2F8094$��10,34,-0.6,9.6q�6`   $��30��6x   $��Informe de gastos de:��6�   � 5(   
   $��10,11.2,9.4,10.4q�6   $��1��6)   $��1��69    5)      �� 5*      �� 5+       5-      �� 5.      $
��Auto �6    �� 5/      $
��Auto �6    �� 50      .+�54      �� $��0��6   $��2��6)   $��0��6=    �� Orientation$ 
Horizontal=�6J   .+�55      ��   
labelStyle#��[ 6   ���	#FF8B195A$��Nombre:��6S   �� 56      #��[ 6   $��Normal"�6\   ��6<   �� $ @Name��6r   57      �� 5:      $��0��6   $��2��6)   $��1��6=   $ 
Horizontal=�6J   .+�5;      �� #��[ 6   ���	#FF8B195A$��Departamento:��6S   �� 5<      #��[ 6   $��Normal"�6b   ��6<   �� $ @Department��6x   5=      � 5?      $��0��6   $��2��6#   $��2��67   $	��Top=�6D   $
��Left=�6\   .+�5A      &   System.Windows.Controls.DataGrid  -   5          columnHeaderStyle   ColumnHeaderStyle# [ 5A   A      AutoGenerateColumns .  	   RowHeaderWidth$	 0Q�6�   $��0,10,-0.2,-10.2q�6�   ��6   �� $ Expense��
   Columns
 5C      4  .System.Windows.Controls.DataGridTemplateColumn  5D      ,  &System.Windows.Controls.DataGridColumn   Header$ Tipo de gasto��61      CellTemplate# [  6H     5E      $ Cantidad��61   # [ 6C   5H      5I      5K      �� 5L   
   $��0��6   $��0��6    $��	logo2.png��6-    J� RenderTransformOrigin$ 0.536,2.166&�6@   $��60��6d   $	��Top=�6p   $
��Left=�6�   $��68��6�   $��	10,10,0,0q�6�   5M      5N      