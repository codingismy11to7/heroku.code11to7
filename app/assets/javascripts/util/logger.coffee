define [], ->
  class Logger
    info: (logline) ->
      window.console?.log logline

  new Logger
