//A python script that graphs stock information using Alpha Vantage's Stock API

import plotly.graph_objs as go
import pandas as pd
import plotly.graph_objs as go
import plotly.offline as pyo
from pandas.io.json import json_normalize
import plotly.tools as tools
import dash
import dash
import dash_html_components as html
import dash_core_components as dcc
from dash.dependencies import Input, Output, State

#Initialize App
app = dash.Dash()

#Define Colors for the UI
colors = {
    'dashbg' : '#2F3036',
    'graphbg' : '#151515',
    'increasingline' : '#4dff4d',
    'decreasingline' : '#193EFD',
    'lowcontrasttext' : '#585A65',
    'highcontrasttext' : '#FAFAFF'
}

#Define Alpha Vantage Function Calls
TIME_SERIES_INTRADAY = 'TIME_SERIES_INTRADAY'
TIME_SERIES_DAILY = 'TIME_SERIES_DAILY'
TIME_SERIES_DAILY_ADJUSTED = 'TIME_SERIES_DAILY_ADJUSTED'
TIME_SERIES_WEEKLY = 'TIME_SERIES_WEEKLY'
TIME_SERIES_WEEKLY_ADJUSTED = 'TIME_SERIES_WEEKLY_ADJUSTED'
TIME_SERIES_MONTHLY = 'TIME_SERIES_MONTHLY'
TIME_SERIES_MONTHLY_ADJUSTED = 'TIME_SERIES_MONTHLY_ADJUSTED'

#Read in stock symbols...
nsdq = pd.read_csv('nsdq.csv')
nyse = pd.read_csv('nyse.csv')
#Get a list of stocks from the csv files, and save them to be used later by the drop down selector bars in the dashboard
nsdq.set_index('Symbol', inplace=True)
nyse.set_index('Symbol', inplace=True)
#Make an array of options for the different types of graphs to be displayed
options = []

for tic in nsdq.index:
    options.append({'label':'{} {}'.format(tic, nsdq.loc[tic]['Name']), 'value':tic})

for tic in nyse.index:
    options.append({'label': '{} {}'.format(tic, nyse.loc[tic]['Name']), 'value':tic})

#Get user input for stock choice and function information
symbol = input('Stock Symbol: \n')
datatype = 'datatype=csv'

function = input("Function: \n")
if function== 'TIME_SERIES_INTRADAY' :
    interval = input('Time interval in minutes: \n')
    symbol = symbol + '&interval=' + interval + 'min'

#Define Api call and the API Key. Get the variable values from the console and make the API reqeust.
API_KEY = 'VW506K51LFXGUT1C'
API_QUERY = 'https://www.alphavantage.co/query?function=' + function + '&symbol=' + symbol + '&' + 'apikey=' + API_KEY+'&' +datatype

#Define Dataframe and resolve issues with Intraday graph range
if function == 'TIME_SERIES_INTRADAY' :
    df = pd.read_csv(API_QUERY)

else:
    df = pd.read_csv(API_QUERY)

#Define the graph type selections
graph_options=[
            {'label': 'Time Series Intraday', 'value' : 'TIME_SERIES_INTRADAY'},
            {'label': 'Time Series Daily', 'value' : 'TIME_SERIES_DAILY'},
            {'label': 'Time Series Daily Adjusted', 'value' : 'TIME_SERIES_DAILY_ADJUSTED'},
            {'label': 'Time Series Weekly', 'value' : 'TIME_SERIES_WEEKLY'},
            {'label': 'Time Series Weekly Adjusted', 'value' : 'TIME_SERIES_WEEKLY_ADJUSTED'},
            {'label': 'Time Series Monthly', 'value' : 'TIME_SERIES_MONTHLY'},
            {'label': 'Time Series Monthly Adjusted', 'value' : 'TIME_SERIES_MONTHLY_ADJUSTED'}
        ]
        
#Use Python's Dash to serve as the front-end for a Dashboard, which displays several graphs of stock information to the user. Where 
#the program is at right now, it currently takes user input from the command line to define the variables, and then offers an option to 
#take more information from the drop down bars and menus in the program. However, these features don't currently update anything on
# the display.

app.layout = html.Div(([
    html.Div([
        dcc.Dropdown(
        id='stock-symbol',
        options=options,
        value='MSFT',
        multi=True)
        ], style={'display': 'flex', 'verticalAlign':'top', 'width':'30%'}),

    html.Div([
        dcc.Dropdown(
            id='graph-type',
            options=graph_options,
            value='TIME_SERIES_DAILY'
    )
    ], style={'display': 'flex', 'verticalAlign':'top', 'width':'30%'}),

    html.Div([
        html.Button(
            id='submit-button',
            children='Submit',
            n_clicks=0,
            style={'fontSize':24, 'marginLeft':'30px'}
        )
    ], style={'display': 'flex', 'verticalAlign': 'top', 'width': '30%'}),

    html.Div([
        dcc.Graph(id='linegraph',
                  figure={
                      'data': [
                          go.Scatter(x=df['timestamp'], y=df['close'],
                                     mode='lines', marker={
                                  'size': 12,
                                  'color': '#4dff4d'
                              })],
                      'layout': go.Layout(title='Stock prices over time')}),
    ]),

    html.Div([
        dcc.Graph(id='candlestick',
                      figure={
                          'data': [
                              go.Candlestick(x=df['timestamp'],
                                             open=df['open'],
                                             high=df['high'],
                                             low=df['low'],
                                             close=df['close'],
                                             increasing_line_color='#4DFF4D',
                                             decreasing_line_color='#193EFD'
                                             )
                          ],
                            'layout': go.Layout(title='Candlestick Graph of prices over time')
                      })

    ])
]
))
@app.callback(Output('linegraph', 'figure'),
              [Input('submit-button', 'n_clicks')],
              [State('stock-symbol', 'value'),
               State('graph-type', 'value')])

def update_figure(n_clicks, selected_graph_type, selected_stock_symbol):
    function = selected_graph_type
    symbol = selected_stock_symbol
    API_QUERY = 'https://www.alphavantage.co/query?function=' + function + '&symbol=' + symbol + '&' + 'apikey=' + API_KEY + '&' + datatype
    df1 = pd.read_csv(API_QUERY)
    return {'data': df1, 'layout': go.Layout(title='Stock prices over time')}



if __name__ == '__main__':
    app.run_server()
