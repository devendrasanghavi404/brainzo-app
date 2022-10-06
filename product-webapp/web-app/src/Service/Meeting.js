import { useMediaQuery, useTheme } from "@material-ui/core";


export const getToken = () => {
    const tokens =  [
        // token
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlrZXkiOiJjNGRjOThjMS05M2RkLTQ1NTEtYTg2My05MjFmYWM0M2IwZDQiLCJwZXJtaXNzaW9ucyI6WyJhbGxvd19qb2luIiwiYWxsb3dfbW9kIl0sImlhdCI6MTY2NDg4MjY3NiwiZXhwIjoxNjY1MTQxODc2fQ.pybYb4SGfkvCInh5Xtawi6X_QRu06of8PVSpSepRm7Q",
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlrZXkiOiJjNGRjOThjMS05M2RkLTQ1NTEtYTg2My05MjFmYWM0M2IwZDQiLCJwZXJtaXNzaW9ucyI6WyJhbGxvd19qb2luIiwiYWxsb3dfbW9kIl0sImlhdCI6MTY2NDg4MjcwNiwiZXhwIjoxNjY1MTQxOTA2fQ.xebZCpyINPLAwdQ_JaoYPWj4xAvcIbVIFhQIzuAZxSE",
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlrZXkiOiJjNGRjOThjMS05M2RkLTQ1NTEtYTg2My05MjFmYWM0M2IwZDQiLCJwZXJtaXNzaW9ucyI6WyJhbGxvd19qb2luIiwiYWxsb3dfbW9kIl0sImlhdCI6MTY2NDg4MjcwNiwiZXhwIjoxNjY1MTQxOTA2fQ.xebZCpyINPLAwdQ_JaoYPWj4xAvcIbVIFhQIzuAZxSE",
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlrZXkiOiJjNGRjOThjMS05M2RkLTQ1NTEtYTg2My05MjFmYWM0M2IwZDQiLCJwZXJtaXNzaW9ucyI6WyJhbGxvd19qb2luIiwiYWxsb3dfbW9kIl0sImlhdCI6MTY2NDg4MjczMCwiZXhwIjoxNjY1MTQxOTMwfQ.tfgOQPK2Y3h-oA_d-3ahQxldRaDgl5LTsN6yGzDCPTI",
        ];
    return tokens[Math.floor(Math.random() * 4)]
}

export const createMeeting = () => {
    return "nd5j-d0yu-3g25"
}

/**
 *
 * @param {{
 * xs: number
 * sm: number
 * md: number
 * lg: number
 * xl: number
 * }} param0
 *
 */

export const useResponsiveSize = ({ xs, sm, md, lg, xl }) => {
  const theme = useTheme();
  const gtThenXS = useMediaQuery(theme.breakpoints.up("xs"));
  const gtThenSM = useMediaQuery(theme.breakpoints.up("sm"));
  const gtThenMD = useMediaQuery(theme.breakpoints.up("md"));
  const gtThenLG = useMediaQuery(theme.breakpoints.up("lg"));
  const gtThenXL = useMediaQuery(theme.breakpoints.up("xl"));

  return gtThenXL
    ? xl
    : gtThenLG
    ? lg
    : gtThenMD
    ? md
    : gtThenSM
    ? sm
    : gtThenXS
    ? xs
    : lg;
};
